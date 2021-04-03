import re

def main():
    sentence = "Hello,; World!. hello?"
    print(count_words(sentence))

def count_words(sentence):
    result = {}
    sentence = sentence.lower()
    words = sentence.split()
    for word in words:
        word = re.sub('[,\\.;!\\?]?', '', word)
        if word in result:
            result[word] = result[word] + 1
        else:
            result[word] = 1
    return result

main()
