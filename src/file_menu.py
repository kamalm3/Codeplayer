#!/usr/bin/env python

import pygame
import sys
import os
from tkinter import Tk, filedialog
from text_input import *
from announcer_voice import *
from controller_layout import *
from setting import *
from controller_settings import *
from run_file import *

BUTTON_WIDTH = 300
BUTTON_HEIGHT = 50
BUTTON_SPACING = 20

controller_initionalisation()

pygame.init()

def save_text(text, filename):
    with open(filename, "w") as file:
        file.write(text)

def save_with_dialog(text):
    root = Tk()
    root.withdraw()  # Hide the root window

    # Open a file dialog for saving
    filename = filedialog.asksaveasfilename(defaultextension=".txt", filetypes=[("Text files", "*.txt")])
    
    if filename:
        save_text(text, filename)
        with open(filename, "r") as file:
            file_contents = file.read()
            file_name_display = filename.split('/')[-1]
            with open("Programs\currentfile.txt", "r+") as config_file:
                config_content = config_file.readlines()
                config_content[-1] = f"current file : {file_name_display}\n"  # Update the last line
                config_file.seek(0)  # Move the file pointer to the beginning
                config_file.writelines(config_content)  # Write the updated content
                config_file.truncate()
        return True  # Return True if save was successful
    else:
        return False  # Return False if user canceled the operation

file_name_display = ""


def rerun_program():
    pygame.quit()
    os.system('python .\codeplayer.py')

def open_file():
    root = Tk()
    root.withdraw()  # Hide the root window

    # Open a file dialog for opening
    filename = filedialog.askopenfilename(filetypes=[("Text files", "*.txt")])
    if filename:
        with open(filename, "r") as file:
            file_contents = file.read()
            file_name_display = filename.split('/')[-1]  # Set file_name_display to the selected filename
            
            # Write the updated value of file_name_display to config.txt
            with open("Programs\currentfile.txt", "r+") as config_file:
                config_content = config_file.readlines()
                config_content[-1] = f"current file : {file_name_display}\n"  # Update the last line
                config_file.seek(0)  # Move the file pointer to the beginning
                config_file.writelines(config_content)  # Write the updated content
                config_file.truncate()  # Truncate any remaining content (in case the new content is shorter)
                
            return file_contents
    return ""

def draw_button(x, y, text, selected):
    GREEN = (0, 255, 0)
    font = pygame.font.Font(None, 32)
    rect = pygame.Rect(x, y, BUTTON_WIDTH, BUTTON_HEIGHT)
    pygame.draw.rect(screen, GREEN if selected else WHITE, rect, 2)
    text_surf = font.render(text, True, WHITE)
    text_rect = text_surf.get_rect(center=rect.center)
    screen.blit(text_surf, text_rect)

def file_name_reset():
    file_name_display = 'untitled.txt'
            
    with open("Programs\currentfile.txt", "r+") as config_file:
        config_content = config_file.readlines()
        config_content[-1] = f"current file : {file_name_display}\n"  # Update the last line
        config_file.seek(0)  # Move the file pointer to the beginning
        config_file.writelines(config_content)  # Write the updated content
        config_file.truncate()  # Truncate any remaining content (in case the new content is shorter)
                
    #return file_contents
def navigate_menu(selected_item, dy, dx):
    new_y = max(0, min(selected_item[1] - dy, len(buttons) - 1))
    new_x = selected_item[0]  # Keep the same column
    return new_x, new_y

buttons = ["Save", "Run file", "Open File", "New File", "Sound Settings", "Controller Settings", "Exit"]

def handle_action_file(selected_item, text_content):
    # Your existing code
    open_file_flag = False
    if buttons[selected_item[1]] == "Save":
        save_with_dialog(text_content)  # Pass text_content to save function
    if buttons[selected_item[1]] == "Open File":
        text_content = open_file()  # Update text_content with loaded text
        open_file_flag = True
    if buttons[selected_item[1]] == "New File":
        file_name_reset()
        text_content = ''  # Reset text_content
        rerun_program()
    if buttons[selected_item[1]] == "Sound Settings":
        config_settings()  # Reset text_content
    if buttons[selected_item[1]] == "Controller Settings":
        controller_settings() # Reset text_content
    if buttons[selected_item[1]] == "Run file":
        run_file()
   
    return text_content, open_file_flag  # Return the modified text_content back to text_editor_pygame.py

def file_menu(text_content):
    screen_width = 1280
    screen_height = 670
    screen = pygame.display.set_mode((screen_width, screen_height))
    pygame.display.set_caption("Pygame Text Editor")
    running = True
    selected_item = (0, 0)
    open_file_flag = False

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.JOYBUTTONDOWN:
                button = event.button
                if button == 1:
                    going_back_sound()
                    running = False
                elif button == 11:
                    selected_item = navigate_menu(selected_item, 1, 0)
                    cursor_navigation_sound()
                elif button == 12:
                    selected_item = navigate_menu(selected_item, -1, 0)
                    cursor_navigation_sound()
                elif button == 0:
                    text_content, open_file_flag = handle_action_file(selected_item, text_content)
                    running = False
                    if buttons[selected_item[1]] == "Exit":
                        file_name_reset()
                        pygame.quit()
            elif event.type == pygame.JOYHATMOTION:
                hat_x, hat_y = event.value
                if hat_y == 1:  # Hat value 1 for moving up
                    selected_item = navigate_menu(selected_item, 1, 0)
                    cursor_navigation_sound()
                elif hat_y == -1:  # Hat value -1 for moving down
                    selected_item = navigate_menu(selected_item, -1, 0)
                    cursor_navigation_sound()
        
        for i, item in enumerate(buttons):
            x = (screen.get_width() - BUTTON_WIDTH) // 2
            y = BUTTON_SPACING + i * (BUTTON_HEIGHT + BUTTON_SPACING)
            draw_button(x, y, item, (selected_item[0] == 0) and (selected_item[1] == i))

        screen.blit(controller_layout_for_other_windows(), (50, 610))

        pygame.display.flip()
        pygame.time.delay(120)

        pygame.display.update()
    return text_content, open_file_flag