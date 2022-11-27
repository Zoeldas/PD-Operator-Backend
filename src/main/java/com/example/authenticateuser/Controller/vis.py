import matplotlib.pyplot as plt
import numpy as np
from scipy.io import wavfile
import pandas as pd
import MySQLdb
db = MySQLdb.connect(
        host="localhost",
        user="root",
        passwd="123456",
        charset='utf8',
        db="jianda")
cur = db.cursor()
print("success")

def paint1(npfile):
    plt.subplot(3,1,1)
    plt.plot(npfile[:,0], 'r')
    plt.xlabel("metric1, sample #")
    plt.subplot(3,1,2)
    plt.plot(npfile[:,1], 'b')
    plt.xlabel("metrics2, sample #")
    plt.subplot(3,1,3)
    plt.plot(npfile[:,2], 'g')
    plt.xlabel("metrics3, sample #")
    plt.tight_layout()
    plt.savefig('./paint1.jpg')
    plt.show()
def freq_amp(signal,move,filename):
    avgtime=(move[-1][-1]-move[-1][0])/(signal.size*1e9)
    fft_spectrum = np.fft.rfft(signal)
    fft_spectrum_abs = np.abs(fft_spectrum)
    freq = np.fft.rfftfreq(signal.size, d=avgtime)
    plt.plot(freq, fft_spectrum_abs)
    plt.xlabel("frequency, Hz")
    plt.ylabel("Amplitude, units")
    plt.savefig(filename)
    plt.show()
    return freq,fft_spectrum_abs
def paint(move1):
    paint1(move1)
    freq_amp(move1[:,0],move1,'')
    freq_amp(move1[:,1],move1,'')
    freq_amp(move1[:,2],move1,'')
sql = "select * from tables=;"
cur.execute(sql)

results = cursor.fetchall()
num_rows = int(cur.rowcount)
# recast this nested tuple to a python list and flatten it so it's a proper iterable:
x = map(list, list(results))              # change the type
x = sum(x, [])                            # flatten

# D is a 1D NumPy array
D = NP.fromiter(iterable=x, dtype=float, count=-1)

# 'restore' the original dimensions of the result set:
D = D.reshape(num_rows, -1)

print(D.shape)
paint(D)