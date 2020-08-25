#!/urs/bin/env python3
# shebang
# Joey Luck
# assignment 7

import sys
import tkinter
from tkinter import Tk, Canvas
import rpack

class CustomCanvas(object): # creates canvas
    def __init__(self, height, width): # canvas constructor

        self.rects: List[Rectangle] = []
        self.window = Tk()
        self.canvas = Canvas(self.window, height=height, width=width)
        self.canvas.pack()

    def place(self, all_rects): # places rectangles on canvas
        for rect in all_rects:
            self.rects.append(
                self.canvas.create_rectangle(
                    rect.x,
                    rect.y,
                    rect.x + rect.width,
                    rect.y + rect.height,
                    fill="blue",
                    outline="black",
                )
            )
        self.window.mainloop()

class Rectangle(object): # rectangle object
    def __init__(self, height, width, x, y): # rectangle constructor
        self.height: int = int(height)
        self.width: int = int(width)
        self.x: int = int(x)
        self.y: int = int(y)

def pack(allRect, canvasSize): # uses rectangle-packer to sort rectangles
    rects = [(rect.width, rect.height) for rect in allRect]
    available = rpack.pack(rects)

    for position, rect in zip(available, allRect): # sets positions for rectangles
        rect.x = position[0]
        rect.y = position[1]

def main():
    if len(sys.argv) > 1:
        path = sys.argv[1]
    else:
        exit(1)

    height = 0
    width = 0

    with open(path) as f: # opens file, retrieves canvas and rectangle sizes
        canvas = tuple(f.readline().strip().split(","))
        rects = [Rectangle(*line.strip().split(","), 0, 0) for line in f]

    pack(rects, canvas)
    canvasView = CustomCanvas(*canvas)
    canvasView.place(rects)

if __name__ == "__main__":
    main()