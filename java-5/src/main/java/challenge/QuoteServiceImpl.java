package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote getQuote() {
        return returnQuote(this.repository.findAll());
    }

    @Override
    public Quote getQuoteByActor(String actor) {
        return returnQuote(this.repository.findByActor(actor));
    }

    private Quote returnQuote(List<Quote> quotes) {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }

}
