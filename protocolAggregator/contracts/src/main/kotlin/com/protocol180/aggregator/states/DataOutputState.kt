package com.protocol180.aggregator.states

import com.protocol180.aggregator.contracts.ProviderAggregationContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.AnonymousParty
import net.corda.core.identity.Party
import java.util.*

@BelongsToContract(ProviderAggregationContract::class)
data class DataOutputState(val consumer: AnonymousParty,
                           val host: Party,
                           val dataOutput: ByteArray,
                           val dateCreated: Date) : ContractState {

    /**
     *  This property holds a list of the nodes which can "use" this state in a valid transaction. In this case, the
     *  consumer or host.
     */
    override val participants: List<AbstractParty> get() = listOf(consumer, host)

}
