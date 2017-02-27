/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.parser;

import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.protocol.message.UnknownHandshakeMessage;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class UnknownHandshakeMessageParser extends HandshakeMessageParser<UnknownHandshakeMessage> {

    public UnknownHandshakeMessageParser(int pointer, byte[] array) {
        super(pointer, array, HandshakeMessageType.UNKNOWN);
    }

    @Override
    public UnknownHandshakeMessage parse() {
        UnknownHandshakeMessage message = new UnknownHandshakeMessage();
        parseType(message);
        parseLength(message);
        message.setData(parseByteArrayField(message.getLength().getValue()));
        return message;
    }
}