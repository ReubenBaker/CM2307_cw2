javac ./*.java -d ./class
echo "CardDeck:"
java -cp ./class TestCardDeck
echo "ThreadSafeCardDeck:"
java -cp ./class TestThreadSafeCardDeck