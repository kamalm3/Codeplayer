import pygame
from announcer_voice import *

def write_settings(sound_state_cursor, sound_state_announcer):
    with open("config.txt", "r") as file:
        lines = file.readlines()

    for i, line in enumerate(lines):
        #print(line)
        if line.startswith("Cursor sound"):
            lines[i] = f"Cursor sound : {sound_state_cursor}\n"
        elif line.startswith("Announcer sound"):
            lines[i] = f"Announcer sound : {sound_state_announcer}\n"

    with open("config.txt", "w") as file:
        file.writelines(lines)

def config_settings():
    pygame.init()
    screen = pygame.display.set_mode((1280, 670))
    pygame.display.set_caption("Settings")

    font = pygame.font.Font(None, 36)

    sound_state_cursor = cursor_sound_on_off() # Default cursor sound state
    sound_state_announcer = announcer_sound_on_off()  # Default announcer sound state

    joystick = None
    if pygame.joystick.get_count() > 0:
        joystick = pygame.joystick.Joystick(0)
        joystick.init()

    running = True
    selected_button = 0  # Initially selected button index
    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.JOYBUTTONDOWN:
                if event.button == 11:
                    selected_button = 0
                elif event.button == 12:
                    selected_button = 1
                if event.button == 0:  # Button 0 (toggle selected sound)
                    if selected_button == 0:
                        sound_state_cursor = "on" if sound_state_cursor == "off" else "off"
                        write_settings(sound_state_cursor, sound_state_announcer)
                    elif selected_button == 1:
                        sound_state_announcer = "on" if sound_state_announcer == "off" else "off"
                        write_settings(sound_state_cursor, sound_state_announcer)
                    #print(sound_state_cursor, sound_state_announcer)
                if event.button == 1:
                    selection_sound()
                    announcer_voice_on()
                    running = False
            elif event.type == pygame.JOYHATMOTION:
                if event.value == (0, 1):  # Hat up
                    selected_button = 0
                elif event.value == (0, -1):  # Hat down
                    selected_button = 1

        screen.fill((0, 0, 0))

        # Cursor sound button
        cursor_button_text = font.render("Cursor Sound: " + sound_state_cursor.capitalize(), True, (255, 255, 255))
        cursor_button_rect = cursor_button_text.get_rect(center=(400, 100))

        # Announcer sound button
        announcer_button_text = font.render("Announcer Sound: " + sound_state_announcer.capitalize(), True, (255, 255, 255))
        announcer_button_rect = announcer_button_text.get_rect(center=(400, 200))

        # Highlight the selected button
        selected_color = (0, 255, 0)
        selected_button_rect = cursor_button_rect if selected_button == 0 else announcer_button_rect
        pygame.draw.rect(screen, selected_color, selected_button_rect, 3)

        screen.blit(cursor_button_text, cursor_button_rect)
        screen.blit(announcer_button_text, announcer_button_rect)

        pygame.display.flip()

  #  pygame.quit()