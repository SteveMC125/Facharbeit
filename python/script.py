import tensorflow as tf
from testData import VALUES
import numpy as np


def saveToFile(content, path):
    with open(path, "w") as file:
        for i in range(len(content)):
            txt = ""
            for j in range(len(content[i])):
                txt = txt + str(content[i][j]) + ","
            file.write(txt[:-1] + "\n")


model = tf.keras.models.load_model("MyModel.h5")

result = model.predict(VALUES)

saveToFile(result, "D:\\Bilder\\Tensorflow\\Data\\answerData2.txt")
for i in range(len(result)):
    print(np.argmax(result[i]))
