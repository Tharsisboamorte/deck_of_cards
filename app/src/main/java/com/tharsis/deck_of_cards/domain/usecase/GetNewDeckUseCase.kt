package com.tharsis.deck_of_cards.domain.usecase


import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.domain.repository.DeckRepository
import com.tharsis.deck_of_cards.utils.common.Resource

class GetNewDeckUseCase(private val deckRepository: DeckRepository) {
    suspend operator fun invoke(): Resource<Deck> {
        return deckRepository.getNewDeck()
    }
}