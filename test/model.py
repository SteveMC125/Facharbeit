import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Flatten
from tensorflow.keras.callbacks import TensorBoard
import numpy as np
import cv2
from trainData import CATEGORIES
from testing import prepare
import time

name = "(64,64),128,512,36NN_relu..sigmoid,adam,SparseCatCross_{}".format(int(time.time()))

tensorboard = TensorBoard(log_dir="D:\\Bilder\\Tensorflow\\logtesting\\{}".format(name))

X = np.load("X.npy")
y = np.load("y.npy")

X = X/255.0

nH1 = 128
nH2 = 512
nOut = 36

model = Sequential([
    Flatten(name="flattening", input_shape=(64, 64)),
    Dense(nH1, name="first_hidden", activation=tf.nn.relu),
    Dense(nH2, name="second_hidden", activation=tf.nn.relu),
    Dense(nOut, name="output", activation=tf.nn.sigmoid)
])

model.compile(optimizer="adam", loss="sparse_categorical_crossentropy", metrics=["accuracy"])

model.fit(X, y, epochs=10, batch_size=150, validation_split=0.1, callbacks=[tensorboard])

model.summary()
model.save("JustDense.h5")

# labels = [[CATEGORIES.index("M")], [CATEGORIES.index("K")], [CATEGORIES.index("G")], [
#     CATEGORIES.index("G")], [CATEGORIES.index("2")], [CATEGORIES.index("3")], [CATEGORIES.index("E")]]
#
# for i in range(7):
#     ev = model.evaluate([prepare("Bilder/bild" + str(i) + ".png")], labels[i], verbose=0)
#     print(int(ev[0]))
