#Explore "Flask" module and create a web server using Flask and python
#Flask is a module usedd to make APIs and Websites

from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

app.run()