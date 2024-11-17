# **CSL448 - Computational Linguistics and Natural Language Processing - Lab Manual**

Welcome to the **NLP Lab Manual**! This manual provides a comprehensive guide to hands-on exercises and experiments using **Python** and the **Natural Language Toolkit (NLTK)** library. The lab manual includes various tasks covering a wide range of Natural Language Processing (NLP) topics, from basic text processing to advanced techniques like Named Entity Recognition and Sentiment Analysis.

## **Objective**
The main objective of this lab manual is to help students explore and implement key NLP concepts using Python. By following this manual, students will gain practical experience with text processing, linguistic analysis, text classification, and more.

## **Lab Exercises Overview**

### **1. Exploring NLTK and Text Corpora**
- **Objective**: Explore Python's NLTK library and examine all the available text corpora.
- **Description**: Learn about the diverse set of text corpora and resources included in NLTK and how to utilize them for NLP tasks.

### **2. Most Frequent Words**
- **Objective**: Identify the most frequently occurring words in a given text.
- **Description**: Write a Python program to find and display the top five most frequent words from a given text.

### **3. Finding Instances of a Word Using Regular Expressions**
- **Objective**: Extract all instances of the word **'the'** from the Brown corpus using regular expressions.
- **Description**: Use regex and NLTK to search for specific words in a large corpus.

### **4. Extracting and Sorting Bigrams and Trigrams**
- **Objective**: Extract all bigrams and trigrams from a given text corpus and sort them by frequency.
- **Description**: Analyze text data by identifying common word pairs (bigrams) and triples (trigrams).

### **5. Add-One Smoothing for Bigram Table**
- **Objective**: Implement Add-One (Laplace) Smoothing for a sparse bigram table.
- **Description**: Smooth out zero probabilities in a bigram language model to handle unseen word pairs.

### **6. Tokenization Using Different Tokenizers**
- **Objective**: Perform sentence and word-level tokenization using different tokenizers available in NLTK.
- **Description**: Compare various tokenization methods, including whitespace, word punct, and regex tokenizers.

### **7. Part of Speech Tagging, Stemming, and Lemmatization**
- **Objective**: Read text data from a file and perform POS tagging, stop-word removal, stemming, and lemmatization.
- **Description**: Analyze the difference between stemming and lemmatization using different stemmers in NLTK.

### **8. Finding Unusual Words**
- **Objective**: Identify unusual words in a given language text.
- **Description**: Write a Python program to list words that do not appear in a standard vocabulary.

### **9. Chunking and Chinking**
- **Objective**: Perform chunking and chinking on text data to extract specific patterns.
- **Description**: Use NLTK’s chunking tools to identify and exclude specific word patterns from text.

### **10. Named Entity Recognition (NER)**
- **Objective**: Implement Named Entity Recognition using NLTK.
- **Description**: Extract named entities (e.g., names of people, organizations, locations) from a given text using NER.

### **11. Text Similarity Analysis**
- **Objective**: Compute the similarity between two sentences using various textual similarity metrics.
- **Description**: Explore different similarity measures such as cosine similarity, Jaccard similarity, and edit distance.

### **12. Word Sense Disambiguation and WordNet Analysis**
- **Objective**: Perform Word Sense Disambiguation (WSD) and extract lexical relationships from WordNet.
- **Description**: List synonyms, antonyms, hypernyms, and hyponyms for each word using WordNet and perform WSD.

### **13. Co-Reference Resolution**
- **Objective**: Implement Co-Reference Resolution in Python.
- **Description**: Identify and resolve references in text to improve understanding of the text’s context.

### **14. Text Classification Using TF-IDF**
- **Objective**: Perform text classification using the TF-IDF vectorization technique.
- **Description**: Implement a simple classifier using TF-IDF to categorize text into predefined categories.

### **15. Sentiment Analysis Using SentiWordNet**
- **Objective**: Analyze the sentiment of hotel reviews using SentiWordNet.
- **Description**: Use SentiWordNet to evaluate the sentiment (positive, negative, neutral) of customer reviews.

---

## **Requirements**
To perform the experiments listed in this manual, ensure you have the following:
- **Python 3.8+**
- **NLTK library** installed (`pip install nltk`)
- **Pandas library** for data manipulation (`pip install pandas`)
- **Additional Libraries**: Some exercises may require additional libraries like `scikit-learn`.

## **Getting Started**
1. Install Python and Jupyter Notebook.
2. Install the required Python packages:
   ```bash
   pip install nltk pandas scikit-learn
   ```
3. Download necessary NLTK data files:
   ```python
   import nltk
   nltk.download('all')
   ```

## **References**
- **NLTK Documentation**: https://www.nltk.org/
- **Python Official Documentation**: https://docs.python.org/3/
- **WordNet**: https://wordnet.princeton.edu/

## **Conclusion**
This lab manual provides practical exercises for learning and implementing core NLP techniques using Python. By following these exercises, students will gain a deeper understanding of text processing, linguistic analysis, and machine learning applications in NLP.

**Happy Learning!** 🎓

---

This **README** provides an overview of the lab manual, details each exercise, and includes instructions for setup and requirements. Let me know if you need any modifications or additional information!