enum NegativeAmountError: Error{
  case lessThanZero
}

func change(_ cents:Int)->Result<(Int, Int, Int, Int), NegativeAmountError>{
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

extension String{
  var stretched: String{
    let trimmed:String = self.replacingOccurrences(of: "\n|\t| ", with: "", options: .regularExpression)
    var stretchedStr:String = ""
    var index:Int=1
    for char in trimmed{
      for _ in 1...index{
        stretchedStr.append(char)
      }
      index+=1
    }
    return stretchedStr
  }
}

extension Array where Element: Hashable{
  func mapThenUnique<U>(fn:(Element)->U)->Set<U>{
    var newArr:[U]=[]
    for item in self{
      newArr.append(fn(item as Element))
    }
    return Set(newArr)
  }
}