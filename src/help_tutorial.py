import pygame
import sys
import os
import subprocess
from announcer_voice import *
from controller_layout import *

# Initialize Pygame
pygame.init()

# Set up the window
WINDOW_WIDTH = 1280
WINDOW_HEIGHT = 670
BUTTON_WIDTH = (WINDOW_WIDTH - 410) // 3
BUTTON_HEIGHT = 100
BUTTON_GAP = 120
ROWS = 3
COLS = 3
NAVIGATION_OUTLINE_COLOR = (0, 255, 0)
BUTTON_COLOR = (25, 25, 25)
BUTTON_PRESSED_COLOR = (60, 60, 60)

# Set up the joystick

controller_initionalisation()
# Function to draw buttons
def draw_button(screen, x, y, width, height, color, text):
    pygame.draw.rect(screen, color, (x, y, width, height))
    font = pygame.font.SysFont(None, 34)
    if text == "Exit":
        text_surface = font.render(text, True, (255,0,0))
    else:
        text_surface = font.render(text, True, (255,255,255))
    text_rect = text_surface.get_rect(center=(x + width // 2, y + height // 2))
    screen.blit(text_surface, text_rect)

def handle_button_press(row, col):
    
    current_path = os.path.dirname(os.path.abspath(__file__))
    if row == 0 and col == 0:
        video_path = current_path + '\Video Tutorials\General Controls.mp4'
    elif row == 0 and col == 1:
        video_path = current_path + '\Video Tutorials\Creating Variables.mp4' 
    elif row == 0 and col == 2:
        video_path = current_path + '\Video Tutorials\Arithmatic.mp4' 
    elif row == 1 and col == 0:
        video_path = current_path + '\Video Tutorials\Running a program.mp4'
    elif row == 1 and col == 1:
        video_path = current_path + '\Video Tutorials\if or otherwise statement.mp4'
    elif row == 1 and col == 2:
        video_path = current_path + '\Video Tutorials\While loop.mp4'
    elif row == 2 and col == 0:
        video_path = current_path + '\Video Tutorials\making functions.mp4'
    elif row == 2 and col == 1:
        video_path = current_path + '\Video Tutorials\Inputs.mp4'
    elif row == 2 and col == 2:
        return
          
    
    # Command to open the video with the default video player
    os.startfile(video_path)

def help_tutorial():
    # Set up Pygame
    pygame.init()

    # Set up the joystick
    pygame.joystick.init()
    joystick = pygame.joystick.Joystick(0)
    joystick.init()
    # Set up the screen
    screen = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
    pygame.display.set_caption("Pygame Button Grid")

    # Main loop
    running = True
    selected_row = 0
    selected_col = 0
    while running:
        screen.fill((0, 0, 0))

        # Handle events
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.JOYBUTTONDOWN:
                if event.button == 11:
                    cursor_navigation_sound()
                    selected_row = max(0, selected_row - 1)
                elif event.button == 12:
                    cursor_navigation_sound()
                    selected_row = min(ROWS - 1, selected_row + 1)
                elif event.button == 13:
                    cursor_navigation_sound()
                    selected_col = max(0, selected_col - 1)
                elif event.button == 14:
                    cursor_navigation_sound()
                    selected_col = min(COLS - 1, selected_col + 1)
                elif event.button == 1:
                    running = False
                elif event.button == 0:
                    selection_sound()
                    handle_button_press(selected_row, selected_col)
                    if row == 2 and col == 2:
                        running = False

            elif event.type == pygame.JOYHATMOTION:
                # Move the cursor based on joystick input (buttons 11 to 14)
                hat_x, hat_y = event.value
                if hat_x == -1:
                    cursor_navigation_sound()
                    selected_col = max(0, selected_col - 1)
                elif hat_x == 1:
                    cursor_navigation_sound()
                    selected_col = min(COLS - 1, selected_col + 1)
                elif hat_y == -1:
                    cursor_navigation_sound()
                    selected_row = min(ROWS - 1, selected_row + 1)
                elif hat_y == 1:
                    cursor_navigation_sound()
                    selected_row = max(0, selected_row - 1)

        # Draw buttons
        for row in range(ROWS):
            for col in range(COLS):
                x = col * (BUTTON_WIDTH + BUTTON_GAP) + 80
                y = row * (BUTTON_HEIGHT + BUTTON_GAP) + 70
                button_color = BUTTON_PRESSED_COLOR if selected_row == row and selected_col == col else BUTTON_COLOR
                if row == 0 and col == 0:
                    text = "General"
                elif row == 0 and col == 1:
                    text = "Variables"
                elif row == 0 and col == 2:
                    text = "Arithmetic"
                elif row == 1 and col == 0:
                    text = "Running a program"
                elif row == 1 and col == 1:
                    text = "If and otherwise"
                elif row == 1 and col == 2:
                    text = "While"
                elif row == 2 and col == 0:
                    text = "Functions"
                elif row == 2 and col == 1:
                    text = "Inputs"
                elif row == 2 and col == 2:
                    text = "Exit"
                draw_button(screen, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, button_color, text)

        font = pygame.font.Font(None, 30)
        above_message = "Select video for tutorial"
        text_surface = font.render(above_message, True, (0,255,0))
        screen.blit(text_surface, (WINDOW_WIDTH//2 - len(above_message) * 5, 10))
        
        screen.blit(controller_layout_for_other_windows(), (50, 610))

        pygame.display.flip()
