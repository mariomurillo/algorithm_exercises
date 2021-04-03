package main

import (
	"fmt"
	"regexp"
	"strings"
)

func main() {
  sentence := "Hello;, World!. hello?"
  fmt.Println(countWords(sentence))
}

func countWords(sentence string) map[string]int {
  result := make(map[string]int)
  sentence = strings.ToLower(sentence)
  regex := regexp.MustCompile(`[,\\.;!\\?]?`)
  words := strings.Split(sentence, " ")
  for _, word := range words {
    word = string(regex.ReplaceAll([]byte(word), []byte(``)))
    val, ok := result[word]
    if ok {
      result[word] = val+1
    } else {
      result[word] = 1
    }
  }
  return result
}
