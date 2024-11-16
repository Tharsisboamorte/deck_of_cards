package com.tharsis.deck_of_cards

import com.tharsis.deck_of_cards.data.dto.deck.DeckResponse
import com.tharsis.deck_of_cards.data.dto.deck.DiscardResponse
import com.tharsis.deck_of_cards.data.dto.deck.PilesResponse
import com.tharsis.deck_of_cards.data.remote.datasource.DeckRemoteDataSource
import com.tharsis.deck_of_cards.domain.model.Deck
import com.tharsis.deck_of_cards.domain.model.Discard
import com.tharsis.deck_of_cards.domain.model.Piles
import com.tharsis.deck_of_cards.domain.repository.DeckRepository
import com.tharsis.deck_of_cards.domain.usecase.GetNewDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReshuffleDeckUseCase
import com.tharsis.deck_of_cards.domain.usecase.ReturnCardsToDeckUseCase
import com.tharsis.deck_of_cards.utils.common.Resource
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class DeckResponseRepositoryTest {

    private val deckRemoteDataSource: DeckRemoteDataSource = mock()
    private lateinit var deckRepository: DeckRepository

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        deckRepository = mock()
    }

    @Test
    fun testGetNewDeck() = coroutineRule.scope.runTest {

        val mockDeckResponse = DeckResponse(
            success = true,
            deckId = "abc123",
            cards = arrayListOf(),
            shuffled = false,
            remaining = 52,
            pilesResponse = null
        )

        whenever(deckRemoteDataSource.getNewDeck()).thenReturn(Resource.Success(mockDeckResponse))


        val mockDeck = Deck(
            success = true,
            id = "abc123",
            cards = emptyList(),
            isShuffled = false,
            remainingCards = 52
        )

        whenever(deckRepository.getNewDeck()).thenReturn(Resource.Success(mockDeck))

        val getNewDeckUseCase = GetNewDeckUseCase(deckRepository)
        val result = getNewDeckUseCase()

        assertTrue(result is Resource.Success<Deck>)
        assertEquals("abc123", result.data.id)
        assertTrue(result.data.success)

        verify(deckRepository).getNewDeck()
    }

    @Test
    fun testReshuffleDeck() = coroutineRule.scope.runTest {

        val mockDeckId = "3p40paa87x90"

        val mockResponse = DeckResponse(
            success = true,
            deckId = "3p40paa87x90",
            shuffled = true,
            remaining = 52
        )

        whenever(deckRemoteDataSource.reshuffleDeck(deckId = mockDeckId)).thenReturn(
            Resource.Success(
                mockResponse
            )
        )

        val mockDeckResult = Deck(
            success = true,
            id = "3p40paa87x90",
            isShuffled = true,
            remainingCards = 52
        )

        whenever(deckRepository.reshuffleDeck(deckId = mockDeckId)).thenReturn(
            Resource.Success(
                mockDeckResult
            )
        )

        val getReshuffleDeckUseCase = ReshuffleDeckUseCase(deckRepository)
        val result = getReshuffleDeckUseCase(mockDeckId)

        assertTrue(result is Resource.Success<Deck>)
        assertEquals(expected = "3p40paa87x90", result.data.id)
        assertTrue(result.data.success)

        verify(deckRepository).reshuffleDeck(mockDeckId)
    }

    @Test
    fun testReturnCardToDeck() = coroutineRule.scope.runTest {

        val mockDeckId = "3p40paa87x90"

        val mockResponse = DeckResponse(
            success = true,
            deckId = "3p40paa87x90",
            shuffled = true,
            remaining = 52,
            pilesResponse = PilesResponse(
                discardResponse = DiscardResponse(remaining = 0)
            )
        )

        whenever(deckRemoteDataSource.returnCardsToDeck(deckId = mockDeckId)).thenReturn(
            Resource.Success(
                mockResponse
            )
        )

        val mockDeckResult = Deck(
            success = true,
            id = "3p40paa87x90",
            isShuffled = true,
            remainingCards = 52,
            piles = Piles(
                discard = Discard(remaining = 0)
            )
        )

        whenever(deckRepository.returnCardsToDeck(deckId = mockDeckId)).thenReturn(
            Resource.Success(
                mockDeckResult
            )
        )

        val getReturnCardsToDeckUseCase = ReturnCardsToDeckUseCase(deckRepository)
        val result = getReturnCardsToDeckUseCase(mockDeckId)

        assertTrue(result is Resource.Success<Deck>)
        assertEquals(expected = "3p40paa87x90", result.data.id)
        assertEquals(expected = 0, result.data.piles.discard.remaining)
        assertTrue(result.data.success)

        verify(deckRepository).returnCardsToDeck(mockDeckId)
    }
}