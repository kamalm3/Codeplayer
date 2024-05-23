
import pygame
import sys
from text_input import *
from controller_layout import *
from controller_settings import *
from add_variable import *
from file_menu import *
from file_menu import open_file
from announcer_voice import *
from run_file import *
from help_tutorial import *
import os

joystick_count = pygame.joystick.get_count()
controller_settings()
pygame.init()

WIDTH, HEIGHT = 1280, 670
WHITE = (255, 255, 255)
GREY = (127,127,127)
screen = pygame.display.set_mode((WIDTH, HEIGHT))

button_size = 50
button_margin = 10
button_x = WIDTH - 1150 - button_size - button_margin  # Adjusted to be at the rightmost position
button_y = HEIGHT - 100 - button_size - button_margin
buttons = {
    'up': pygame.Rect(button_x, button_y - button_size - button_margin, button_size, button_size),
    'down': pygame.Rect(button_x, button_y + button_size + button_margin, button_size, button_size),
    'left': pygame.Rect(button_x - button_size - button_margin, button_y, button_size, button_size),
    'right': pygame.Rect(button_x + button_size + button_margin, button_y, button_size, button_size)
}


last_direction = 'up'
button_value = None

def text_editor_window():
    file_name_reset()
    reset_loaded_variable()
    controller_initionalisation()
    pygame.display.set_caption("Code Play")
    clock = pygame.time.Clock()
    text_editor_width, text_editor_height = 850, 600
    max_width = text_editor_width
    max_height = text_editor_height

    last_direction = 'up'
    button_value = None

    open_file_flag = False  # Flag to track if a file was opened

    text_editor = TextInput(font,  max_width, max_height)
    clock = pygame.time.Clock()
    is_running = True

    while is_running:
        screen.blit(controller_layout(), (0, 0))
        controller_button_layout = controller_buttons()
        text_editor_surface = pygame.Surface((text_editor_width, text_editor_height))
        text_editor_surface.fill((50, 50, 50))
        text_editor.display(text_editor_surface)
        screen.blit(text_editor_surface, (200,0))

        current_file = get_current_file()

        text_surface = font.render("Current File:" + str(current_file), True, (0, 255, 100))
        text_rect = text_surface.get_rect(center=(310, 640))
        screen.blit(text_surface, text_rect)
        curren_variable_loaded = place_loaded_variable()
        variable_text_surface = font.render("Loaded Variable/function:" + place_loaded_variable(), True, (0, 255, 100))
        variable_text_rect = text_surface.get_rect(center=(910, 640))
        screen.blit(variable_text_surface, variable_text_rect)
        up_buttons = {0: 'display ', 1: 'if ', 2: 'otherwise ', 3: curren_variable_loaded}
        down_buttons = {0: '+', 1: '-', 2: '*', 3: '/'}
        left_buttons = {0: '()', 1: '{}', 2: 'return ', 3: 'while '}
        right_buttons = {0: '>', 1: '<', 2: '!=', 3: '='}

        fontcontrols = pygame.font.Font(None, 30)
        text_surface = fontcontrols.render(f"Variable menu", True, WHITE)
        screen.blit(text_surface, (10, 10))
        fontcontrols = pygame.font.Font(None, 30)
        text_surface = fontcontrols.render(f"Delete", True, WHITE)
        screen.blit(text_surface, (120, 100))
        fontcontrols = pygame.font.Font(None, 30)
        text_surface = fontcontrols.render(f"Newline", True, WHITE)
        screen.blit(text_surface, (WIDTH - 100, 10))
        text_surface = fontcontrols.render(f"Space", True, WHITE)
        screen.blit(text_surface, (WIDTH - 180, 100))
        text_surface = fontcontrols.render(f"File Menu", True, WHITE)
        screen.blit(text_surface, (WIDTH - 180, 330))
        text_surface = fontcontrols.render(f"Help", True, WHITE)
        screen.blit(text_surface, (120, 330))

        for button in buttons.values():
            pygame.draw.rect(screen, (100, 100, 100), button)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                is_running = False
                file_name_reset()
            elif event.type == pygame.JOYBUTTONDOWN:
                button = event.button
                if button == 13:
                    text_editor.move_left()
                elif button == 14:
                    text_editor.move_right()
                elif button == 11:
                    text_editor.move_up()
                elif button == 12:
                    text_editor.move_down()
                if button in controller_button_layout:
                    action = controller_button_layout[button]
                    if action == 'delete character':
                        text_editor.remove(1)
                    elif action == 'space':
                         text_editor.write(' ')
                    elif action == "Help":
                         lost_sound()
                         help_tutorial()
                    elif action == '%':
                         text_editor.write('%')
                    elif action == ',':
                         text_editor.write(',')
                    elif action == 'file menu':
                        going_back_sound()
                        text_content, open_file_flag = file_menu(text_editor.get_text())
                        if open_file_flag:  # If a file was opened
                            text_editor.lines = ['']  # Clear the text editor
                            text_editor.write(text_content)
                elif last_direction:
                    if last_direction == 'up':
                        button_dict = up_buttons
                    elif last_direction == 'down':
                        button_dict = down_buttons
                    elif last_direction == 'left':
                        button_dict = left_buttons
                    elif last_direction == 'right':
                        button_dict = right_buttons

                    for button, value in button_dict.items():
                        if joystick.get_button(button):
                            button_value = value
                            text_editor.write(button_value)
                            break    
            elif event.type == pygame.JOYAXISMOTION:
                if event.axis == 4:  # Axis 4: Left and right motion
                     if event.value == 1:  
                         going_back_sound()
                         add_variable()
                if event.axis == 5:  # Axis 4: Left and right motion
                     if event.value == 1:  #
                         text_editor.newline()
            elif event.type == pygame.JOYHATMOTION:
                hat_value = event.value
                if hat_value[0] == 0 and hat_value[1] == 1:  # Hat value: (0, -1)
                    text_editor.move_up()
                elif hat_value[0] == 0 and hat_value[1] == -1:  # Hat value: (0, 1)
                    text_editor.move_down()
                elif hat_value[0] == -1 and hat_value[1] == 0:  # Hat value: (-1, 0)
                    text_editor.move_left()
                elif hat_value[0] == 1 and hat_value[1] == 0:  # Hat value: (1, 0)
                    text_editor.move_right()

        joystick_count = pygame.joystick.get_count()
        if joystick_count > 0:
            joystick = pygame.joystick.Joystick(controller_number())
            joystick.init()
            axis_x = joystick.get_axis(0)
            axis_y = joystick.get_axis(1)

        # Determine the direction based on axis values
            if axis_x < -0.5:
                direction = 'left'
            elif axis_x > 0.5:
                direction = 'right'
            elif axis_y < -0.5:
                direction = 'up'
            elif axis_y > 0.5:
                direction = 'down'
            else:
                direction = None

            if last_direction:
                if last_direction == 'up':
                    gear = 'Default'
                if last_direction == 'down':
                    gear = 'Arithmatic'
                if last_direction == 'left':
                    gear = 'Advanced'
                if last_direction == 'right':
                    gear = 'Inequalities'
                fontgear = pygame.font.Font(None, 30)
                text_surface = fontgear.render(f"Left Analog stick", True, GREEN)
                screen.blit(text_surface, (10, 405))
                text_surface2 = fontgear.render(f"{gear}", True, GREEN)
                screen.blit(text_surface2, (1100, 390))
        
        # Save the last direction
            if direction:
                last_direction = direction

        # Draw buttons
            for button, rect in buttons.items():
                pygame.draw.rect(screen, GREEN if last_direction == button else BLACK, rect)
                pygame.draw.rect(screen, (0, 0, 0), rect, 2)  # Draw button outline

            y_offset = 390
            for direction, button_dict in [("up", up_buttons), ("down", down_buttons), ("left", left_buttons), ("right", right_buttons)]:
                if direction == last_direction:
                    y_offset += 30
                    for button, value in button_dict.items():
                        text_surface = font.render(f"{value}", True, GREEN)
                        screen.blit(text_surface, (SCREEN_WIDTH - 140, y_offset))
                        y_offset += 60
       
        pygame.display.flip()
        clock.tick(30)

    pygame.quit()
    sys.exit()
