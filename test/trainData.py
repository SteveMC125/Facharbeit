import numpy as np
import os
import cv2
import random


def readAndResize(filepath):
    img_array = cv2.imread(filepath, cv2.IMREAD_GRAYSCALE)
    new_array = cv2.resize(img_array, (64, 64))
    return new_array


DATADIR = "D:/Bilder/Tensorflow/Data/English/Fnt"
CATEGORIES = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
              "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
IMG_SIZE = 64

training_data = []


def makeData():
    for category in CATEGORIES:
        path = os.path.join(DATADIR, category)
        class_num = CATEGORIES.index(category)
        for img in os.listdir(path):
            try:
                img_array = readAndResize(os.path.join(path, img))
                training_data.append([img_array, class_num])
            except Exception as e:
                pass

    random.shuffle(training_data)

    X = []
    y = []

    for features, label in training_data:
        X.append(features)
        y.append(label)

    X = np.array(X).reshape(-1, IMG_SIZE, IMG_SIZE)

    np.save("X.npy", X)
    np.save("y.npy", y)
