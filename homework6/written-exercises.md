1. * &A[0][0] = **0x601190**   
 Address is **0x601190**, A[0][0] is the base_address of the 2d Array in hexadecimal.  
   * &A[3][7] = **0x6012A0**  
 Address of A[i][j] would be the:  
 base_address + "size of struct" * (i * c + j) (the size of struct is 8 bytes, 4 for the int and 4 for the char)  
 so for A[3][7], i=3, j=7, c=9 (for the # of elements in each row):  
 = 0x601190h + (8 * (3 * 9 + 7))d  
 = 0x601190h + (8 * (34))d  
 = 0x601190h + 272d (now to convert the decimal 272 to hexadecimal)  
 = 0x601190h + 110h  
 = **0x6012A0**h which is the Address of A[3][7] and by running  
 "std::cout << &A[3][7];"  
  we get the address of A[3][7] to be **0x6012A0**
 2. * C++  
    i. double \*a[n];  
    ii. double (\*b)[n];  
    iii. double (\*c())[n];  
    iv. double (\*d[n])();  
    v. double (\*f(int (\*)(int, int[]), int)) (int, ...);  
    * Go  
    i. a \*[n]float64  
    ii. b \*[n]float64  
    iii. c func() \*[n]float64  
    iv. d [n]\*func() float64  
    v.   
