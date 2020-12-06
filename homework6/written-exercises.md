1.  * &A[0][0] = **0x601190**   
 Address is **0x601190**, A[0][0] is the base_address of the 2d Array in hexadecimal.  
  * &A[3][7] = **0x6012A0**  
 Address of A[3][7] would be the:  
 base_address + "size of struct" * (3 * 9 + 7) (the size of struct is 8 bytes, 4 for the int and 4 for the char)  
 = 0x601190h + (8*(34))d  
 = 0x601190h + 272d (now to convert the decimal 272 to hexadecimal)
 = 0x601190h + 110h
 = **0x6012A0**h which is the Address of A[3][7] and by running  
 "std::cout << &A[3][7];"  
  we get the address of A[3][7] to be **0x6012A0**
 2.   
  ToDo
