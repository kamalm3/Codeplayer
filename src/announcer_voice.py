#!/usr/bin/env python

import pygame

def cursor_sound_on_off():
    with open('config.txt', 'r') as file:
        lines = file.readlines()
    i = 0
    while i < len(lines):
        cursor_sound_on_off = lines[0].strip().split()[-1]
        i = i + 1
    return cursor_sound_on_off

def announcer_sound_on_off():
    with open('config.txt', 'r') as file:
        lines = file.readlines()
    i = 0
    while i < len(lines):
        announcer_sound_on_off = lines[1].strip().split()[-1]
        i = i + 1
    return announcer_sound_on_off

def create_new_varaiabele_announcer():
    if announcer_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/create_new_variable.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(1600)  # Wait for sound to finish

def announcer_voice_on():
    if announcer_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/announcer_voice_on.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100)) 

def cursor_navigation_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/cursor_navigation_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(int(sound.get_length() * 1000))  # Wait for sound to finish

def selection_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/selection_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(1)  # Wait for sound to finish

def going_back_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/going_back_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100))  # Wait for sound to finish

def combination_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/variable_meaning_combination_sound2.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100))  # Wait for sound to finish

def variable_loaded_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/variable_meaning_combination sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100))

def variable_creation_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/variable_created_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100))  # Wait for sound to finish
# Example usage

def program_successful_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/program_successful_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100)) 

def lost_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/program_fail_sound.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.play()
    pygame.time.wait(pygame.time.wait(100)) 

def variable_added_sound():
    if announcer_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/variable_added.wav"
    sound = pygame.mixer.Sound(audio_file)
    #sound.set_volume(3.0)
    sound.play()
    pygame.time.wait(pygame.time.wait(100)) 

def add_variable_sound():
    if cursor_sound_on_off() == 'off':
        return
    pygame.init()
    pygame.mixer.init()
    audio_file = "audio/Add_variable.wav"
    sound = pygame.mixer.Sound(audio_file)
    sound.set_volume(3.0)
    sound.play()
    pygame.time.wait(pygame.time.wait(100)) 

