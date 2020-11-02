import Foundation

//****#1****
enum NegativeAmountError: Error{
  case lessThanZero
}

func change(_ cents: Int)->Result<(Int, Int, Int, Int), NegativeAmountError>{
  if cents<0{
    return Result.failure(NegativeAmountError.lessThanZero)
  }
  var centsRemaining=cents
  var arr:[Int]=[]
  for coin in [25,10,5,1]{
    let change=centsRemaining.quotientAndRemainder(dividingBy:coin)
    centsRemaining=change.remainder
    arr.append(change.quotient)
  }
  return Result.success((arr[0],arr[1],arr[2],arr[3]))
}
//Did this before watching Homework 4 Helper video
/* 
extension String{
  var stretched: String{
    let trimmed: String = self.replacingOccurrences(of: "\n|\t| ", with: "", options: .regularExpression)
    var stretchedStr: String = ""
    var index: Int=1
    for char in trimmed{
      for _ in 1...index{
        stretchedStr.append(char)
      }
      index+=1
    }
    return stretchedStr
  }
}
*/
//****#2****
extension String{
  var stretched: String{
    return self.filter{if String($0).contains(" ")||String($0).contains("\t")||String($0).contains("\n"){
        return false
        }else{ 
        return true
        }
      }.enumerated().map{
        let number: Int = $0.0
        let char = $0.1
        var consecutive: String = ""
        for _ in 0...number{
          consecutive.append(char)
        }
        return consecutive
    }.joined()
  }  
}

//****#3****
extension Array where Element: Hashable{
  func mapThenUnique<T>(fn:(Element)->T)->Set<T>{
    //Did this before watching Homework 4 Helper video
    /*var newArr:[T]=[]
    for item in self{
      newArr.append(fn(item as Element))
    }
    return Set(newArr)
    */
    return Set(self.map{fn($0)})
  }
}

//****#4****
func powers(of base: Int, through limit: Int, closure: (Int) -> ()){
  var index:Int = 0
  var current:Int = 0
  while current<limit {
    current = Int(pow(Double(base), Double(index)))
    if current<=limit{
      closure(current)
    }
    index+=1
  }
}

//****#5****


//****#6****
struct Sayer{
  var phrase: String 
  func and(_ word: String)->Sayer{
    return Sayer(phrase: phrase+" \(word)")
  }
}
func say(_ word: String)->Sayer{
  return Sayer(phrase:word)
}

//****#7****
func twice<T>(_ f: (T)->T, appliedTo x: T)-> T {
  return f(f(x))
}

//****#8****
func uppercasedFirst(of array: [String], longerThan minLength: Int) -> String?{
  return array.first(where: {$0.length>minLength})?.uppercased()
}