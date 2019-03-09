import tensorflow as tf
import numpy as np
import time

print("start creating model")

print("load training data")
xTrain = np.load("xTrain.npy")
yTrain = np.load("yTrain.npy")

name = "4096,128,512,36NN_relu..softmax,adam,catCross_{}".format(int(time.time()))

tensorboard = tf.keras.callbacks.TensorBoard(
    log_dir="D:\\Bilder\\Tensorflow\\logsTest\\{}".format(name), write_images=True, write_graph=False, batch_size=200, histogram_freq=1, write_grads=True)

# 64 * 64 images
nIn = 4096
nH1 = 128
nH2 = 512
nOut = 36
print("creating model")
model = tf.keras.models.Sequential([
    tf.keras.layers.Dense(nH1, input_shape=(nIn,), name="first_hidden", activation=tf.nn.relu),
    tf.keras.layers.Dense(nH2, name="second_hidden", activation=tf.nn.relu),
    tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.softmax)
])
print("compile model")
model.compile(optimizer="adam", loss="categorical_crossentropy", metrics=["accuracy"])
print("fit model")
model.fit(xTrain, yTrain, epochs=10, batch_size=200, validation_split=0.2, callbacks=[tensorboard])
model.summary()

model.save("MyModel.h5")

print("model saved")
print(name)
