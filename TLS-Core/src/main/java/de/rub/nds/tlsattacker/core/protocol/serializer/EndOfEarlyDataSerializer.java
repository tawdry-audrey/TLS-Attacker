/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.serializer;

import de.rub.nds.tlsattacker.core.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.core.protocol.message.EndOfEarlyDataMessage;

/**
 * RFC draft-ietf-tls-tls13-21
 */
public class EndOfEarlyDataSerializer extends HandshakeMessageSerializer<EndOfEarlyDataMessage> {

    public EndOfEarlyDataSerializer(EndOfEarlyDataMessage message, ProtocolVersion version) {
        super(message, version);
    }

    @Override
    public byte[] serializeHandshakeMessageContent() {
        return getAlreadySerialized(); // empty message
    }

}
