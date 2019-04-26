import random

approval = input("Guess the number game - lets play (y or n)? ")
while approval.lower() == "y":
	tryagainflag = True
	v = random.randrange(1, 100)
	n = int(input("Enter a number: "))
	attempt = 1
	while tryagainflag:
		if v>n:
			n = int(input("Try entering larger number: "))
			attempt += 1
		elif v<n:
			n = int(input("Try entering smaller number: "))
			attempt += 1
		elif v==n:
			print(f"Good, you got it in {attempt} attempts")
			tryagainflag = False
			approval = input("Want to play again (y or n)? ")
