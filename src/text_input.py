import pygame

class TextInput:
    def __init__(self, font, screen, max_width):
        self.lines = ['']
        self.cursor = (0, 0)  # (row, column)
        self.font = font
        self.screen = screen
        self.max_width = max_width

    def write(self, text):
        row, col = self.cursor
        line = self.lines[row]
        self.lines[row] = line[:col] + text + line[col:]
        self.cursor = (row, col + len(text))

    def remove(self, num_chars):
        row, col = self.cursor
        line = self.lines[row]
        self.lines[row] = line[:max(col - num_chars, 0)] + line[col:]
        self.cursor = (row, max(col - num_chars, 0))

    def newline(self):
        row, col = self.cursor
        self.lines.insert(row + 1, '')
        self.cursor = (row + 1, 0)

    def move_up(self):
        row, col = self.cursor
        if row > 0:
            self.cursor = (row - 1, min(col, len(self.lines[row - 1])))

    def move_down(self):
        row, col = self.cursor
        if row < len(self.lines) - 1:
            self.cursor = (row + 1, min(col, len(self.lines[row + 1])))

    def move_left(self):
        row, col = self.cursor
        if col > 0:
            self.cursor = (row, col - 1)
        elif row > 0:
            self.cursor = (row - 1, len(self.lines[row - 1]))

    def move_right(self):
        row, col = self.cursor
        if col < len(self.lines[row]):
            self.cursor = (row, col + 1)
        elif row < len(self.lines) - 1:
            self.cursor = (row + 1, 0)

    def get_data_at_cursor(self, data, extracted_data):
        cursor_pos_y, cursor_pos_x = self.cursor
        if cursor_pos_x == 0:
            return data[cursor_pos_y]
        else:
            return extracted_data[cursor_pos_y]

    def write_data_at_cursor(self, data, extracted_data):
        text_to_write = self.get_data_at_cursor(data, extracted_data)
        self.write(text_to_write)

    def display(self, screen):
        y_offset = 0
        for i, line in enumerate(self.lines):
            rendered_text = self.font.render(line, True, (255, 255, 255))
            screen.blit(rendered_text, (0, y_offset))
            if i == self.cursor[0]:
                cursor_pos = self.font.size(line[:self.cursor[1]])
                pygame.draw.line(screen, (255, 255, 255), (cursor_pos[0], y_offset), (cursor_pos[0], y_offset + rendered_text.get_height()), 2)
            y_offset += rendered_text.get_height()

    def get_text(self):
        return '\n'.join(self.lines)
    
    def write(self, text):
        row, col = self.cursor
        line = self.lines[row]
        parts = text.split('\n')
        self.lines[row] = line[:col] + parts[0] + line[col:]
        self.cursor = (row, col + len(parts[0]))
        for part in parts[1:]:
            row += 1
            self.lines.insert(row, part)
            self.cursor = (row, len(part))

    def cleartext(self):
        self.lines = ['']
        self.cursor = (0, 0)

    