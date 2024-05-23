import pygame
import sys
from announcer_voice import *
from controller_layout import *
# Initialize Pygame
pygame.init()

# Set up colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GREEN = (0, 255, 0)

# Set up screen dimensions
SCREEN_WIDTH, SCREEN_HEIGHT = 1280, 670
global variable_created_name
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("On-Screen Keyboard")

# Set up font
font = pygame.font.Font(None, 36)

# Define keyboard layout
keyboard_layout_name = [
    ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'],
    ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'],
    ['z', 'x', 'c', 'v', 'b', 'n', 'm', "_"],
    ['SPACE', 'DEL', 'ENTER']
]
keyboard_layout_value = [
    ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'],
    ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'],
    ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', "/"],
    ['z', 'x', 'c', 'v', 'b', 'n', 'm', "+", "-", "*"],
    ["input()", '"', '.', 'SPACE', 'DEL', 'ENTER']
]
# Function to draw the keyboard with cursor
def draw_keyboard_name(selected_row, selected_col):
    key_width = 100
    key_height = 50
    x_offset = 50
    y_offset = SCREEN_HEIGHT - 290
    y = y_offset
    for i, row in enumerate(keyboard_layout_name):
        x = x_offset
        for j, key in enumerate(row):
            color = GREEN if (i, j) == (selected_row, selected_col) else (50,50,50)
            pygame.draw.rect(screen, color, (x, y, key_width, key_height))
            text_surface = font.render(key, True, WHITE)
            screen.blit(text_surface, (x + key_width // 4, y + key_height // 4))
            x += key_width + 10
        y += key_height + 10

def draw_keyboard_value(selected_row, selected_col):
    key_width = 100
    key_height = 50
    x_offset = 50
    y_offset = SCREEN_HEIGHT - 290
    y = y_offset
    for i, row in enumerate(keyboard_layout_value):
        x = x_offset
        for j, key in enumerate(row):
            color = GREEN if (i, j) == (selected_row, selected_col) else (50,50,50)
            pygame.draw.rect(screen, color, (x, y, key_width, key_height))
            text_surface = font.render(key, True, WHITE)
            screen.blit(text_surface, (x + key_width // 4, y + key_height // 4))
            x += key_width + 10
        y += key_height + 10

# Function to handle text input with on-screen keyboard
def input_name():
    global variable_created_name
    input_box = pygame.Rect(450, 150, 200, 32)
    name = ''
    active = True

    selected_row = 0
    selected_col = 0

    while active:
        controller_button_layout = controller_buttons()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RETURN:
                    return name
                elif event.key == pygame.K_BACKSPACE:
                    name = name[:-1]
                else:
                    name += event.unicode
            if event.type == pygame.JOYHATMOTION:
                hat_x, hat_y = event.value
                if hat_x == -1:
                    selected_col = (selected_col - 1) % len(keyboard_layout_name[selected_row])
                elif hat_x == 1:
                    selected_col = (selected_col + 1) % len(keyboard_layout_name[selected_row])
                elif hat_y == 1:
                    selected_row = (selected_row - 1) % len(keyboard_layout_name)
                elif hat_y == -1:
                    selected_row = (selected_row + 1) % len(keyboard_layout_name)
            if event.type == pygame.JOYBUTTONDOWN:
                button = event.button
                if button in controller_button_layout:
                    action = controller_button_layout[button]
                    if action == 'file menu':
                        return name
                if button == 11:  # Button 11 (UP)
                    selected_row = (selected_row - 1) % len(keyboard_layout_name)
                elif button == 12:  # Button 12 (DOWN)
                    selected_row = (selected_row + 1) % len(keyboard_layout_name)
                elif button == 13:  # Button 13 (LEFT)
                    selected_col = (selected_col - 1) % len(keyboard_layout_name[selected_row])
                elif button == 14:  # Button 14 (RIGHT)
                    selected_col = (selected_col + 1) % len(keyboard_layout_name[selected_row])
                elif button == 1:
                    active = False
                elif button == 2:
                    name += ' '
                elif button == 3:
                    name = name[:-1]
                elif button == 0:  # For other buttons
                    if keyboard_layout_name[selected_row][selected_col] == 'SPACE':
                        name += ' '
                    elif keyboard_layout_name[selected_row][selected_col] == 'DEL':
                        name = name[:-1]
                    elif keyboard_layout_name[selected_row][selected_col] == 'ENTER':
                        return name
                    else:
                        name += keyboard_layout_name[selected_row][selected_col]
        
        variable_created_name = name

        screen.fill(BLACK)
        font_value = pygame.font.Font(None, 40)
        text_surface = font_value.render(f"Enter the NAME of the variable", True, GREEN)
        screen.blit(text_surface, (450, 25))
        text_surface = font_value.render(f"setv", True, GREEN)
        screen.blit(text_surface, (370, 150))
        text_surface = font_value.render(f"-> VALUE", True, GREEN)
        screen.blit(text_surface, (670, 150))
        pygame.draw.rect(screen, WHITE, input_box, 2)
        text_surface = font.render(name, True, WHITE)
        screen.blit(text_surface, (input_box.x + 5, input_box.y + 5))
        draw_keyboard_name(selected_row, selected_col)  # Draw the on-screen keyboard
        screen.blit(controller_layout_for_text_creation(), (50, 300))
        pygame.display.flip()


# Function to input surname
def input_surname():
    input_box = pygame.Rect(570, 150, 150, 32)
    surname = ''
    active = True

    selected_row = 0
    selected_col = 0

    while active:
        controller_button_layout = controller_buttons()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RETURN:
                    return surname
                elif event.key == pygame.K_BACKSPACE:
                    surname = surname[:-1]
                else:
                    surname += event.unicode
            if event.type == pygame.JOYHATMOTION:
                hat_x, hat_y = event.value
                if hat_x == -1:
                    selected_col = (selected_col - 1) % len(keyboard_layout_value[selected_row])
                elif hat_x == 1:
                    selected_col = (selected_col + 1) % len(keyboard_layout_value[selected_row])
                elif hat_y == 1:
                    selected_row = (selected_row - 1) % len(keyboard_layout_value)
                elif hat_y == -1:
                    selected_row = (selected_row + 1) % len(keyboard_layout_value)
            if event.type == pygame.JOYBUTTONDOWN:
                button = event.button
                if button in controller_button_layout:
                    action = controller_button_layout[button]
                    if action == 'file menu':
                        return surname
                if button == 11:  # Button 11 (UP)
                    selected_row = (selected_row - 1) % len(keyboard_layout_value)
                elif button == 12:  # Button 12 (DOWN)
                    selected_row = (selected_row + 1) % len(keyboard_layout_value)
                elif button == 13:  # Button 13 (LEFT)
                    selected_col = (selected_col - 1) % len(keyboard_layout_value[selected_row])
                elif button == 14:  # Button 14 (RIGHT)
                    selected_col = (selected_col + 1) % len(keyboard_layout_value[selected_row])
                elif button == 1:
                    active = False
                elif button == 2:
                    surname += ' '
                elif button == 3:
                    surname = surname[:-1]
                elif button == 0:  # For other buttons
                    if keyboard_layout_value[selected_row][selected_col] == 'SPACE':
                        surname += ' '
                    elif keyboard_layout_value[selected_row][selected_col] == 'DEL':
                        surname = surname[:-1]
                    elif keyboard_layout_value[selected_row][selected_col] == 'ENTER':
                        return surname
                    else:
                        surname += keyboard_layout_value[selected_row][selected_col]

        screen.fill(BLACK)
        font_value = pygame.font.Font(None, 40)
        text_surface = font_value.render(f"Enter the VALUE of the variable", True, GREEN)
        screen.blit(text_surface, (450, 25))
        text = f"setv {variable_created_name} ->"
        text_surface = font_value.render(text, True, GREEN)
        text_width, text_height = font_value.size(text)
        text_x = input_box.x - text_width - 10  # Adjust 10 for some padding
        text_y = input_box.y
        screen.blit(text_surface, (text_x, text_y))
        pygame.draw.rect(screen, WHITE, input_box, 2)
        text_surface = font.render(surname, True, WHITE)
        screen.blit(text_surface, (input_box.x + 5, input_box.y + 5))
        draw_keyboard_value(selected_row, selected_col)  # Draw the on-screen keyboard
        screen.blit(controller_layout_for_text_creation(), (50, 300))
        pygame.display.flip()

# Function to save to file
def save_to_file(name, surname):
    with open('database.txt', 'a') as file:
        file.write(f"setv {name} -> {surname}\n")


# Function to create variable window
def create_variable_window():
    name = input_name()
    if name is None:  # If user chose to go back
        return
    combination_sound()
    surname = input_surname()
    if surname is None:  # If user chose to go back
        return
    save_to_file(name, surname)
    variable_creation_sound()

# Example usage:
# create_variable_window()  # This will initiate the process of inputting name and surname and then save to the file 'database.txt'
