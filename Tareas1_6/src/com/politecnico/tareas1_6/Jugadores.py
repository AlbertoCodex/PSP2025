# Created on : Oct 22, 2023, 10:34:04 AM
# Author     : Alberto


# This is a sample Python script.

# Press Shift+F6 to execute it or replace it with your code.

import json
import sys

jugador = { "Cristiano Ronaldo":
    {
        "Club":"Al-Nassr F.C.",
        "año":1985,
        "Equipos Anteriores":[
            {"Equipo":"Manchester United"},
            {"Equipo":"Juventus"},
            {"Equipo":"Real Madrid"},
        ]
    }
}
print(json.dumps(jugador))
sys.exit(0)