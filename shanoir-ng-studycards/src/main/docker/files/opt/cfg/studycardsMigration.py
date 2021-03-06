#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import pymysql

sourceConn = pymysql.connect(host="mysql", user="shanoir", password="shanoir", database="shanoirdb", charset="utf8")
targetConn = pymysql.connect(host="localhost", user="shanoir", password="shanoir", database="shanoir_ng_studycards", charset="utf8")

sourceCursor = sourceConn.cursor()
targetCursor = targetConn.cursor()

print("Import study cards: start")
    
sourceCursor.execute("SELECT STUDY_CARD_ID, ACQUISITION_EQUIPMENT_ID, CENTER_ID, IS_DISABLED, NAME, NIFTI_CONVERTER_ID, STUDY_ID FROM STUDY_CARD")

query = "INSERT INTO study_cards (id, acquisition_equipment_id, center_id, disabled, name, nifti_converter_id, study_id) VALUES (%s, %s, %s, %s, %s, %s, %s)"

targetCursor.executemany(query, sourceCursor.fetchall())
targetConn.commit()

print("Import study cards: end")

sourceConn.close()
targetConn.close()
