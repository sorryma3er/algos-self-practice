class solution:
    def int_to_roman(self, num: int) -> str:
        roman: str = ''
        
        while num > 0:
            if num // 1000 > 0:
                fac = num // 1000
                roman += fac * 'M'
                num %= 1000
            elif num // 100 > 0:
                fac = num // 100
                if fac >= 9:
                    roman += 'CM'
                    num -= 900
                elif fac >= 5:
                    roman += 'D'
                    num -= 500
                elif fac >= 4:
                    roman += 'CD'
                    num -= 400
                else:
                    roman += fac * 'C'
                    num -= 100 * fac
            elif num // 10 > 0:
                fac = num // 10
                if fac >= 9:
                    roman += 'XC'
                    num -= 90
                elif fac >= 5:
                    roman += 'L'
                    num -= 50
                elif fac >= 4:
                    roman += 'XL'
                    num -= 40
                else:
                    roman += fac * 'X'
                    num -= fac * 10
            elif num // 1 > 0:
                if num >= 9:
                    roman += 'IX'
                    num -= 9
                elif num >= 5:
                    roman += 'V'
                    num -= 5
                elif num >= 4:
                    roman += 'IV'
                    num -= 4
                else:
                    roman += 'I' * num
                    num -= num
            
                
        return roman
    
    
if __name__ == '__main__':
    num = 1287
    print(solution().int_to_roman(num))