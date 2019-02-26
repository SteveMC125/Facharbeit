import tensorflow as tf
from Data import XS, YS
import numpy as np

print("start creating model")

# 64 * 64 images
nIn = 4096
nH1 = 1024
nH2 = 512
nH3 = 512
nOut = 36

model = tf.keras.models.Sequential([
    tf.keras.layers.Dense(nH1, input_shape=(nIn,), name="first_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nH2, name="second_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nH3, name="third_hidden", activation=tf.nn.sigmoid),
    tf.keras.layers.Dense(nOut, name="output", activation=tf.nn.sigmoid)
])
model.compile(tf.keras.optimizers.Adam(0.001), tf.keras.losses.categorical_crossentropy)

model.fit(XS, YS, epochs=20, steps_per_epoch=5)
model.summary()

model.save("MyModel.h5")

print("model saved")
