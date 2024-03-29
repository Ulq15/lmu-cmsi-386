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
6. ```javascript
   let isPrime = (n) => {  
    return new Promise((resolve, reject) => {  
      if (isNaN(n) || !Number.isInteger(n)){  
        reject({n, error: "Not an integer"})  
      }  
      else if (n<2 || n>Number.MAX_SAFE_INTEGER){  
        reject({n, error: "Number too big or too small"})  
      }  
      let f = (n, k) =>{  
        if(k > n/2){  
          resolve(true)  
        }  
        else if(n%k === 0){  
          resolve(false)  
        }  
        else{  
          return f(n, k+1)  
        }  
      }  
      return f(n, 2)        
    }).then(result=>{ return result}, failure=>{return failure.error})  
   };
   ```
7. The “billion dollar mistake”, which is the creation of the null reference, applies only to statically typed languages (meaning type checking is done at compile time not run time), it has nothing to do with Python and other dynamically typed languages (type checking is done at run time) because with dynamically typed languages all references have the top type ⊤, the supertype of all types, which can and does reference any value. The type restrictions are not on the references but the values to which the references point. Python does not care if "var x" is an integer, string, etc, because x is a reference to a value and not the value itself. So the billion dollar mistake doesn't apply to Python.  
8. ```go
   func main() {  
     ch := make(chan float64)  
     go powers(2, 64, ch)  
     for i := range ch {  
       fmt.Println(i)  
     }  
   }  

   func powers(base float64, limit float64, ch chan float64) {  
     i := float64(0)  
     for math.Pow(base, i) <= limit{  
       ch <-math.Pow(base, i)  
       i++  
     }  
     close(ch)  
   }  
   ```
