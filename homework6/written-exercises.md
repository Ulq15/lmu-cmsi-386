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
    i. double \*a[n];  (a is a pointer to an array of n doubles)  
    ii. double (\*b)[n];  (b is a pointer to an array of n doubles)  
    iii. double (\*c())[n];  (c is a function taking unspecified number of arguments and returning a pointer to an array of n doubles)  
    iv. double (\*d[n])();  (d is an array of n pointers to functions taking unspecified number of arguments and returning double)  
    v. double (\*f(int (\*)(int, int[]), int)) (int, ...);  
      * f is a function that takes:  
        (1) a function that takes an int and an array of int which returns an int and  
        (2) an int  
      * and returns a pointer to a function that takes an int and an unspecefied number of other parameters and returns a double.  
    * Go (doesnt have doubles so I chose float64)  
    i. a \*[n]float64  
    ii. b \*[n]float64  
    iii. c func() \*[n]float64  
    iv. d [n]\*func() float64  
    v. f func(func(int, []int) int, int) \*func(int, ...) float64
3.  * a) f() * h() - x with static scope rules  
        => 1 * 1 - 1 = **0**  
    * b) f() * h() - x with dynamic scope rules  
        => 1 * 3 - 1 = **2**
4.  * a) output with   _deep_  binding: **8**
    * b) output with _shallow_ binding: **5**
5.  * a) by _value_: **1 2 3 4**
    * b) by _reference_: **2 2 3 4**
    * c) by _value-result_: **2 2 2 4**
    * d) by _name_: **2 2 3 4**
6.  * 
