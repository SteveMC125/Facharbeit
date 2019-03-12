import numpy as np
import os
import cv2
import random

print("laoding training data...")

# UTIL FUNCTION


def readAndResize(filepath, imSize=64):
    # read image as grayscale
    img_array = cv2.imread(filepath, cv2.IMREAD_GRAYSCALE)
    # return resized image
    return cv2.resize(img_array, (imSize, imSize))


# READEING TRAIN DATA

# init vars for directory for images
DATADIR = "D:/Bilder/Tensorflow/Data/English/Fnt"
CATEGORIES = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
              "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
IMG_SIZE = 64

training_data = []


def makeData():
    # iterate over the categories of images
    for category in CATEGORIES:
        # create path to category and label for category
        path = os.path.join(DATADIR, category)
        class_num = CATEGORIES.index(category)
        # iterate over every image in the categorydirectory
        for img in os.listdir(path):
            try:
                # read and resize the image
                img_array = readAndResize(os.path.join(path, img))
                # put image and label in array
                training_data.append([img_array, class_num])
            except Exception as e:
                pass

    # shuffle the Data for better training result
    random.shuffle(training_data)

    # create arrays for images / label
    X = []
    y = []

    # unpack data
    for features, label in training_data:
        X.append(features)
        y.append(label)

    # convert and resize image array (Keras/Tensorflow needs special format of images)
    X = np.array(X).reshape(-1, IMG_SIZE, IMG_SIZE)

    # normalize images
    X = X/255.0

    # save images and labels
    np.save("X.npy", X)
    np.save("y.npy", y)


makeData()


print("done loading data")
