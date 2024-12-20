from datetime import date
import os
import requests

current_file_dir = os.path.dirname(__file__)

# input what year to select for
today = date.today()
today_year = today.strftime("%Y")
today_day = today.strftime("%d")
year = int(input(f'What year would you like to play ({today_year}):') or today_year)
day = int(input(f'What date would you like to play ({today_day}):') or today_day)
lang = input(f'What language would you like to play (python|ruby):')

challenge_path = f'{current_file_dir}/../{year}/{day:02d}'
os.makedirs(challenge_path)

if lang == "python":
    with open(challenge_path+f'/day{day}.py', "w") as solution_file,\
        open(f'{current_file_dir}/template/template.py') as template_file:
        solution_file.write(template_file.read())
elif lang == "ruby":
    with open(challenge_path+f'/day{day}.rb', "w") as solution_file,\
        open(f'{current_file_dir}/template/template.rb') as template_file:
        solution_file.write(template_file.read())
else:
    print("unsupported language")

with open(challenge_path+f'/example', "w") as solution_file:
    solution_file.writelines('')

with open(challenge_path+f'/input', "w") as input_file,\
    open('.advent_secrets') as secrets_file:
    key, secret = secrets_file.readline().strip().split('=')
    link = f"https://adventofcode.com/{year}/day/{day}/input"
    f = requests.get(link, cookies=dict(session=secret))
    input_file.write(f.text)
