
import socket

HOST='localhost'
PORT=49171
MENSAJE_A_ENVIAR=223

#AF_INET --> indica que se utiliza una direccion ipv4
#SOCK_STREAM --> indica que el protocolo es TCP

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST,PORT))
    s.send(MENSAJE_A_ENVIAR.to_bytes(1,'little'))
    mensaje_recibido=s.recv(1)
    mensaje_recibido=int.from_bytes(mensaje_recibido,'little')
    print("Cliente mensaje enviado:",MENSAJE_A_ENVIAR)
    print("Cliente mensaje recibido:",mensaje_recibido)