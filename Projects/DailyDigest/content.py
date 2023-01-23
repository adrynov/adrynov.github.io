import csv
import random

import requests


def get_random_quote(quotes="quotes.csv"):
    """
    Retrieve a random quote from the CSV file
    """
    try:
        with open(quotes) as csvfile:
            quotes = [{'author': line[0], 'quote': line[1]} for line in csv.reader(csvfile, delimiter='|')]

    except Exception as e:  # use a default quote to help things turn out for the best
        quotes = [{'author': 'Eric Idle', 'quote': 'Always Look on the Bright Side of Life.'}]

    return random.choice(quotes)


def generate_quote():
    """
     Get a random famous quotes in many languages.

     https://rapidapi.com/martin.svoboda/api/quotes15
    """
    url = "https://quotes15.p.rapidapi.com/quotes/random/"

    headers = {
        "X-RapidAPI-Key": "d6d9823095mshdb533fd5fde4ff8p13830djsn5e77307f195f",
        "X-RapidAPI-Host": "quotes15.p.rapidapi.com"
    }

    response = requests.request("GET", url, headers=headers)
    print(response.text)


def retrieve_forecast():
    pass


def retrieve_trends():
    pass


def retrieve_article():
    pass
