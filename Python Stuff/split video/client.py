import wx,os,time,socket as soc,mediaplayer as mp
import multiprocessing,sys,subprocess

s=soc.socket(soc.AF_INET,soc.SOCK_STREAM)
s.connect(("localhost",1231))
second=open('2.mp4','wb')
first = True
while(True):#create thread
    inp = s.recv(1024*1024)
    if(inp==""):
        print("jai")
        break
    else:
        second.write(inp)
        #Start mediaplayer only 1st time
        print("received")
        if(first):
            first = False
            subprocess.Popen("python mediaplayer.py",shell=True)
            
second.close() 


'''
MplayerCtrl:
	GetVideoBitrate
	GetAudioBitrate
	'''
'''def find_header_length(self):
	length = self.mpc.GetTimeLength()
	self.videoRate = self.mpc.GetVideoBitate()
	self.audioRate = self.mpc.GetAudioBitrate()
	videoSize = length * videoRate/8
	audioSize = length * audioRate/8
	
	filesize = os.path.getsize()
	self.headerLength = filesize - videoSize - audioSize
	return self.headerLength
	
def request_from_byte_value(self,secs):
	self.headerLength + secs * (self.videoRate + self.audioRate)/8'''
