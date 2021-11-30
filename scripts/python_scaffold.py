from datetime import date
import os

# input what year to select for
today = date.today()
today_year = today.strftime("%Y")
today_day = today.strftime("%d")
year = input(f'What year would you like to play ({today_year}):') or today_year
day = input(f'What date would you like to play ({today_day}):') or today_day

challenge_path = f'{os.path.dirname(__file__)}/../{year}/{day}'
os.makedirs(challenge_path)
