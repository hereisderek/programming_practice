import Foundation
// function to return the complete input as string
func input() -> String {
   let inputData = NSFileHandle.fileHandleWithStandardInput().availableData
   let inputString = NSString(data: inputData, encoding:NSUTF8StringEncoding)! as String
    return inputString
}
// num holds the input provided
let num = input()

// split using space or newline as delimiter.
let nums : [String] = split(num) {
    $0 == " " || $0 == "\n"
}

// convert the strings to integer.
let a = nums[0].toInt()!
let b = nums[1].toInt()!

print(a + b)