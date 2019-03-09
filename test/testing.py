import cv2
import tensorflow as tf
import numpy as np
from trainData import CATEGORIES, readAndResize


def prepare(filepath):
    new_array = readAndResize(filepath)
    return new_array.reshape(-1, 64, 64)


def pred():
    model = tf.keras.models.load_model("JustDense.h5")
    for i in range(7):
        prediction = model.predict(
            [(prepare("D:/Bilder/Tensorflow/testing/bild" + str(i) + ".png") / 255.0)])
        # print(CATEGORIES[np.argmax(prediction)])
        print(np.argmax(prediction))


pred()
