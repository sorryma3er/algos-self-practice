import random

def rand_role(roles: list[str]) -> tuple:
    length: int = len(roles)
    
    result1 = random.choice(roles)
    roles.remove(result1)
    
    result2 = random.choice(roles)
    roles.remove(result2)
    
    return result1, result2

if __name__ == "__main__":
    roles:list[str] = ["Plant", "Resource Investigator", "Co-ordinator", "Shaper", "Monitor-Evaluator", "Team Worker", "Implementer", "Completer-Finisher"]
    
    print(rand_role(roles))