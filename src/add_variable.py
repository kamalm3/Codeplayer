import pygame
import sys
from announcer_voice import *
from creating_variable import *
from create_new_function import *
from unnasigned_variable_creation import *
from controller_layout import *

def save_database(data):
    with open("database.txt", "w") as file:
        for line in data:
            file.write(line + "\n")
# Function to load data from database.txt
def load_data():
    with open("database.txt", "r") as file:
        return list(reversed([line.strip() for line in file if line.strip()]))

# Function to extract data between "setv" and "->"
def extract_data(line):
    if "setv" in line:
        start_index = line.find("setv") + len("setv")
        end_index = line.find("->")
        if start_index != -1 and end_index != -1:
            return line[start_index:end_index].strip()
    elif "function" in line:
        start_index = line.find("function") + len("function")
        end_index = line.find("(")
        if start_index != -1 and end_index != -1:
            return f'{line[start_index:end_index].strip()}()'
    return ""

# Function to display text on the screen
def draw_text(surface, text, font, color, x, y):
    text_surface = font.render(text, True, color)
    surface.blit(text_surface, (x, y))

def loaded_variable(v):
    # Read the content of the config.txt file
    with open('config.txt', 'r') as file:
        lines = file.readlines()
    for i, line in enumerate(lines):
        if line.startswith("Loaded Variable:"):
            lines[i] = "Loaded Variable: " + v + "\n"
            break 
    with open('config.txt', 'w') as file:
        file.writelines(lines)

def reset_loaded_variable():
    # Read the content of the config.txt file
    with open('config.txt', 'r') as file:
        lines = file.readlines()
    for i, line in enumerate(lines):
        if line.startswith("Loaded Variable:"):
            lines[i] = "Loaded Variable: " + "None" + "\n"
            break 
    with open('config.txt', 'w') as file:
        file.writelines(lines)

def place_loaded_variable():
    loaded_variable = None
    with open('config.txt', 'r') as file:
        for line in file:
            if line.strip().startswith('Loaded Variable'):
                loaded_variable = line.strip().split(':')[1].strip()
                break
    return loaded_variable

def add_variable():
    pygame.init()
    controller_initionalisation()

    data = load_data()
    buttons = []
    for i, line in enumerate(data):
        buttons.append(line.strip())

    # Screen dimensions
    screen_width = 1280
    screen_height = 670

    # Colors
    white = (255, 255, 255)
    green = (0, 255, 0)

    # Font
    font = pygame.font.Font(None, 36)

    # Load data from the database
    data = load_data()

    # Extract data for the second column
    extracted_data = [extract_data(line) for line in data]

    # Pygame window setup
    screen = pygame.display.set_mode((screen_width, screen_height))
    pygame.display.set_caption("Button Navigation")
    clock = pygame.time.Clock()

    # Cursor setup
    cursor_pos_y = 0  # Cursor position for rows
    cursor_pos_x = 0  # Cursor position for columns

    # Main loop
    selected_button_index = 0
    running = True
    while running:
        screen.fill((0,0,0))

        # Event handling
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.JOYBUTTONDOWN:
                if event.button == 11:
                    cursor_navigation_sound()
                    cursor_pos_y = max(0, cursor_pos_y - 1)
                elif event.button == 12:
                    cursor_navigation_sound()
                    cursor_pos_y = min(len(data) - 1, cursor_pos_y + 1)
                elif event.button == 13: 
                    cursor_navigation_sound()
                    cursor_pos_x = 0
                elif event.button == 14:
                    cursor_navigation_sound()
                    cursor_pos_x = 1
                elif event.button == 3:
                    selection_sound()
                    running = False
                    create_function_window()
                elif event.button == 2:
                    selection_sound()
                    create_new_varaiabele_announcer()
                    running = False
                    create_variable_window()
                elif event.button == 1:
                    going_back_sound()
                    running = False
                elif event.button == 0:
                    if cursor_pos_x == 0:
                        variable_loaded_sound()
                        variable_added_sound()
                        loaded_variable(str(data[cursor_pos_y]))
                        running = False
                    else:
                        variable_loaded_sound()
                        variable_added_sound()
                        loaded_variable(str(extracted_data[cursor_pos_y]))
                        running = False
            elif event.type == pygame.JOYAXISMOTION:
                if event.axis == 4:  # Axis 4: Left and right motion
                    if event.value == 1: 
                         lost_sound()
                         if cursor_pos_y < len(data):  # Check if cursor position is valid
                            del data[cursor_pos_y]  # Delete from data list
                            buttons.pop(cursor_pos_y)  # Delete from buttons list
                            save_database(data)
                            cursor_pos_y = min(cursor_pos_y, len(buttons) - 1)  # Update cursor position
                if event.axis == 5:  # Axis 4: Left and right motion
                    if event.value == 1:
                         selection_sound() 
                         create_unnasigned_variable_window()
                         running = False


            elif event.type == pygame.JOYHATMOTION:
                hat_x, hat_y = event.value
                if hat_x == -1:
                    cursor_navigation_sound()
                    cursor_pos_x = 0
                elif hat_x == 1:
                    cursor_navigation_sound()
                    cursor_pos_x = 1
                elif hat_y == 1:
                    cursor_navigation_sound()
                    cursor_pos_y = cursor_pos_y = max(0, cursor_pos_y - 1)
                elif hat_y == -1:
                    cursor_navigation_sound()
                    cursor_pos_y = min(len(data) - 1, cursor_pos_y + 1)

        colors = []
        for line in data:
            if "setv" in line:
                colors.append((255, 255, 0))  # Green color for lines with "setv"
            elif "function" in line:
                colors.append((255, 0, 0))  # Red color for lines with "def func"
            else:
                colors.append((0, 100, 255)) 

        for i, (line, extracted, color) in enumerate(zip(data, extracted_data, colors)):
            draw_text(screen, line, font, color, 100, 100 + i * 40)
            draw_text(screen, extracted, font, color, 700, 100 + i * 40)

        cursor_rect_y = 95 + cursor_pos_y * 40
        cursor_rect_x = 40 if cursor_pos_x == 0 else 640

        font = pygame.font.Font(None, 30)
        text_surface = font.render(f"Choose the variable you want to add to the variable load. Either in the assigned form or called form", True, (220,220,220))
        screen.blit(text_surface, (200, 20))
        text_surface = font.render(f"Variable/Function assigned form", True, (255,255,255))
        screen.blit(text_surface, (100, 70))
        text_surface = font.render(f"Called form", True, (255,255,255))
        screen.blit(text_surface, (900, 70))
        screen.blit(controller_layout_for_variable_popup(), (50, 610))

        pygame.draw.rect(screen, green, (cursor_rect_x, cursor_rect_y, 640, 34), 3)

        pygame.display.flip()
