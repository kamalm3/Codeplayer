import os
import subprocess
#from text_editor_pygame import get_current_file
from announcer_voice import *

def get_current_file():
    directory = "Programs"
    #print("Current directory:", os.getcwd())
    if os.path.exists(directory):
        try:
            with open(os.path.join(directory, 'currentfile.txt'), 'r') as file:
                for line in file:
                    if line.startswith('current file :'):
                        return line.split(':', 1)[1].strip()
                    
        except FileNotFoundError:
            print(f"File 'currentfile.txt' not found in directory '{directory}'.")
    else:
        print(f"Directory -> '{directory}' not found.")

def create_batch_file():
    filename = str(get_current_file()).split(".")[0] + ".simple"
    directory = "Programs"
    if os.path.exists(directory):
        os.chdir(directory)
        with open('run_java.bat', 'w') as batch_file:
            batch_file.write(f'java Main {filename}\n')
        os.chdir("..")
    

def create_conversion_file():
    textfile = str(get_current_file())
    simplefile = str(get_current_file()).split(".")[0] + ".simple"
    directory = "Programs"
    if os.path.exists(directory):
        os.chdir(directory)
        with open('converttxtsimple.bat', 'w') as batch_file:
            batch_file.write(f'copy {textfile} {simplefile}\n')
        os.chdir("..")

def open_batch_file():
    print("Current directory:", os.getcwd())
    directory = "Programs"
    try:
        program_successful_sound()
        os.chdir(directory)
        subprocess.run(['converttxtsimple.bat'], shell=True, check=True)
        result = subprocess.run(['start', 'cmd', '/k', 'run_java.bat'], shell=True, check=True)
        if result.returncode != 0:
            lost_sound()
            print("Error:", result.stdout)
        os.chdir("..")
    except subprocess.CalledProcessError as e:
        lost_sound()
        print(f"Error occurred while executing the batch file: {e}")

def run_file():
    try:
        create_batch_file()
        create_conversion_file()
        open_batch_file()
    except Exception as e:
        print(f"An error occurred: {e}")
