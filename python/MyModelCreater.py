import tensorflow as tf
from Data import xTrain, yTrain
import numpy as np

print("start creating model")

# 64 * 64 images
nIn = 4096
nH1 = 1024
nH2 = 512
nOut = 36
print("creating model")
model = tf.keras.models.Sequential([
    tf.keras.layers.Dense(nH1, input_shape=(nIn,), name="first_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nH2, name="second_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.sigmoid)
])
print("compile model")
model.compile(tf.keras.optimizers.Adam(0.001), tf.keras.losses.mean_squared_error)
print("fit model")
model.fit(xTrain, yTrain, epochs=3, steps_per_epoch=30)
model.summary()

model.save("MyModel.h5")

print("model saved")
