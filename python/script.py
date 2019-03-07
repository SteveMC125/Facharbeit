import tensorflow as tf
from testData import VALUES
import numpy as np

translation = {
    1: "0",
    2: "1",
    3: "2",
    4: "3",
    5: "4",
    6: "5",
    7: "6",
    8: "7",
    9: "8",
    10: "9",
    11: "A",
    12: "B",
    13: "C",
    14: "D",
    15: "E",
    16: "F",
    17: "G",
    18: "H",
    19: "I",
    20: "J",
    21: "K",
    22: "L",
    23: "M",
    24: "N",
    25: "O",
    26: "P",
    27: "Q",
    28: "R",
    29: "S",
    30: "T",
    31: "U",
    32: "V",
    33: "W",
    34: "X",
    35: "Y",
    36: "Z"
}


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
    print(translation[np.argmax(result[i])])
