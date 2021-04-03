use std::collections::HashMap;

use regex::Regex;

fn main() {
    let sentence = "Hello, ;World!. hello?".to_owned();
    let result = count_words(sentence);
    println!("result: {:?}", result);
}
fn count_words(sentence: String) -> HashMap<String, usize> {
    let mut result: HashMap<String, usize> = HashMap::new();
    let sentence_lowercase = sentence.to_lowercase();
    let regex = Regex::new("[,\\.;!\\?]?");
    let clean_sentence = if let Ok(r) = regex {
        r.replace_all(&sentence_lowercase, "").to_string()
    } else {
        sentence_lowercase
    };
    let words: Vec<&str> = clean_sentence.split(' ').collect();
    for word in words {
        if let Some(v) = result.get_mut(word) {
            *v += 1;
        } else {
            result.insert(word.to_owned(), 1);
        }
    }
    result
}
