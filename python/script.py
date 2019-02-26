import tensorflow as tf
from testData import TESTIMAGES
import numpy as np


def saveToFile(content, path):
    print(content)
    print(path)


model = tf.keras.models.load_model("MyModel.h5")

result = model.predict(TESTIMAGES, steps=1)

saveToFile(result, "D:\\Bilder\\Tensorflow\\Data\\answerData.txt")
