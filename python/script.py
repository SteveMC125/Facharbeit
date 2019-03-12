import cv2
import tensorflow as tf
from tensorflow.keras.models import load_model
import numpy as np
from Data import CATEGORIES, readAndResize

# UTIL FUNCTIONS


def prepare(filepath, imSize=64):
    # read and resize image
    new_array = readAndResize(filepath)
    # resize image array and return this
    return new_array.reshape(-1, imSize, imSize)


def saveToFile(content, path):
    with open(path, "w") as file:
        for i in range(len(content)):
            txt = ""
            for j in range(len(content[i])):
                txt = txt + str(content[i][j]) + ","
            file.write(txt[:-1] + "\n")


def pred(imageDir="D:/Bilder/Tensorflow/testing"):
    # load trained model
    model = load_model("MyModel.h5")

    # predict images
    predictions = []
    for img in os.listdir(imageDir):
        predictions.append(model.predict([prepare(os.path.join(imageDir, img))]))
    # save predictions to file
    # saveToFile(predictions, "D:\\Bilder\\Tensorflow\\Data\\answerData2.txt")
    print(predictions)

# CATEGORIES[np.argmax(one_prediction)]
