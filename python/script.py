import tensorflow as tf
from testData import TESTIMAGES
import numpy as np


def saveToFile(content, path):
    with open(path, "w") as file:
        for i in range(len(content)):
            txt = ""
            for j in range(len(content[i])):
                txt = txt + str(content[i][j]) + ","
            file.write(txt + "\n")


model = tf.keras.models.load_model("MyModel.h5")

result = model.predict(TESTIMAGES, steps=1)

saveToFile(result, "D:\\Bilder\\Tensorflow\\Data\\answerData2.txt")
print(result[0])
