FROM python:3.10-slim

WORKDIR /app

#COPY requirements.txt .
#RUN pip install -r requirements.txt

COPY Student.py DatabaseManager.py main.py ./

RUN pip install pymongo


CMD ["python", "./main.py"]