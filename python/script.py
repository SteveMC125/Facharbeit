from tensorflow.keras.models import load_model
import numpy as np
import cv2
import os


CATEGORIES = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
              "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]


# UTIL FUNCTIONS

def readAndResize(filepath, imSize=64):
    # read image as grayscale
    img_array = cv2.imread(filepath, cv2.IMREAD_GRAYSCALE)
    # return resized image
    return cv2.resize(img_array, (imSize, imSize))


def prepare(filepath, imSize=64):
    # read and resize image
    new_array = readAndResize(filepath)
    # resize image array and return this
    return new_array.reshape(-1, imSize, imSize)


def saveToFile(preds, path="D:/Bilder/Tensorflow/Data/answerData.txt"):
    with open(path, "w") as file:
        txt = ""
        # iterate over answers for images
        for pred in preds:
            # append txt by the translatet answer + linebreak
            txt = txt + CATEGORIES[np.argmax(pred[0])] + "\n"
        # write everything to the file
        file.write(txt)


def pred(imageDir="D:/Bilder/Tensorflow/Data/testImages"):
    # load trained model
    model = load_model("MyModel.h5")

    # predict images
    predictions = []
    for img in os.listdir(imageDir):
        predictions.append(model.predict([prepare(os.path.join(imageDir, img))]))
    # save predictions to file
    saveToFile(predictions)


# call prediction FUNCTION
pred()
